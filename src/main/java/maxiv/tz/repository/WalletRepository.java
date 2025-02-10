package maxiv.tz.repository;

import jakarta.persistence.LockModeType;
import jakarta.validation.constraints.NotNull;
import maxiv.tz.models.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface WalletRepository extends CrudRepository<Wallet, UUID>,JpaSpecificationExecutor<Wallet>{
    //@Lock(LockModeType.PESSIMISTIC_WRITE)
    //Optional<Wallet> findByWalletId(UUID uuid);



}
