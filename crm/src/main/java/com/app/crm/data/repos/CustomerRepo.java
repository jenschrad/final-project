
package com.app.crm.data.repos;

import com.app.crm.data.entities.Customer; // import entity 
import org.springframework.data.repository.CrudRepository; // import crud repo
import org.springframework.stereotype.Repository;

// interface that extends CrudReposistory interface from spring data JPA framework
@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
    
}
