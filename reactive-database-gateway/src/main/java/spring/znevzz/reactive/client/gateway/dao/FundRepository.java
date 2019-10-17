package spring.znevzz.reactive.client.gateway.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.znevzz.reactive.client.gateway.model.Fund;

public interface FundRepository extends MongoRepository<Fund, Long> {
}
