package com.example.employeeManagement.Repository;

import com.example.employeeManagement.Model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

    @Query(value = "select * from complaint where uid = :userid", nativeQuery = true)
    List<Complaint> getComplaintByUserId(Long userid);

    @Query(value = "select * from complaint where empid is null", nativeQuery = true)
    List<Complaint> getNotAssignedComplaints();

    @Query(value = "select * from complaint where status = 1 or status = 0", nativeQuery = true)
    List<Complaint> getLiveComplaint();
}
