package maxiv.tz.servises;

import maxiv.tz.Controllers.WalletController;
import maxiv.tz.repository.WalletRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.MessageSource;

import static org.junit.jupiter.api.Assertions.*;

class WalletServiceImplTest {
    @Mock
    WalletServiceImpl walletService;
    @Mock
    WalletRepository walletRepository;
    @InjectMocks
    WalletController walletController;
    @Mock
    MessageSource messageSource;

    @Test
    void findWalletById() {


    }

    @Test
    void depositOperations() {


    }

    @Test
    void allWallets() {


    }

}