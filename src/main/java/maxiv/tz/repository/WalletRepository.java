package maxiv.tz.repository;

import jakarta.persistence.LockModeType;
import maxiv.tz.models.Wallet;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface WalletRepository extends CrudRepository<Wallet, UUID>,JpaSpecificationExecutor<Wallet>{
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Wallet> findByWalletId(UUID uuid);



}
