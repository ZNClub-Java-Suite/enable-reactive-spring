package spring.znevzz.reactive.file.gateway.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.znevzz.reactive.file.gateway.model.Fund;

public interface FundRepository extends MongoRepository<Fund, Long> {
}
