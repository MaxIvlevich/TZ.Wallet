package maxiv.tz.repository;

import maxiv.tz.models.Wallet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface WalletRepository extends CrudRepository<Wallet, UUID>,JpaSpecificationExecutor<Wallet>{




}
