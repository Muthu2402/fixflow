// It is a Bridge Between service and Database
/*  JpaRepository --> auto enable
{ save(),findById(),findAll(),deleteById(),count(),existById() }
*/
package com.fixflow.fixflow.repository;

import com.fixflow.fixflow.entity.Complaint;
import com.fixflow.fixflow.enums.ComplaintStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    Long countByStatus(ComplaintStatus status);

}
