package spring.znevzz.reactive.database.gateway.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.znevzz.reactive.database.gateway.model.Fund;

public interface FundRepository extends MongoRepository<Fund, Long> {
}
