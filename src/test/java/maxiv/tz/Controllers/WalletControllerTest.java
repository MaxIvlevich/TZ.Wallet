package maxiv.tz.Controllers;

import maxiv.tz.DTO.WalletDTO;
import maxiv.tz.DTO.WalletIncomeDTO;
import maxiv.tz.DTO.WalletResponse;
import maxiv.tz.repository.WalletRepository;
import maxiv.tz.servises.WalletServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static maxiv.tz.models.enums.OperationType.DEPOSIT;
import static maxiv.tz.models.enums.OperationType.WITHDRAW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WalletControllerTest {


      @Mock
      WalletServiceImpl walletService;
      @Mock
      WalletRepository walletRepository;
      @InjectMocks
      WalletController walletController;
      @Mock
      MessageSource messageSource;



     @BeforeEach
    void setUp(){
         MockMvc mockMvc = MockMvcBuilders.standaloneSetup(walletController)
                 .build();

     }

    @Test
    void walletBalanceGetValidTest(){
        //given
        WalletDTO walletDTO = new WalletDTO(UUID.randomUUID(),new BigDecimal(1));
        //WalletDTO walletDTO1 = new WalletDTO(UUID.randomUUID(),new BigDecimal(1));

        //when
        when(this.walletService.findWalletById(walletDTO.getWalletId())).thenReturn(walletDTO);
        var responseEntity = this.walletController.walletBalance(walletDTO.getWalletId());

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(walletDTO,responseEntity.getBody());

    }

    @Test
    void depositOperationsTest() {
        //given
        WalletIncomeDTO walletIncomeDTO = new WalletIncomeDTO(UUID.randomUUID(),DEPOSIT,new BigDecimal(1));
        WalletDTO walletDTO = new WalletDTO(UUID.randomUUID(),new BigDecimal(1));

        //when
        when(this.walletService.depositOperations(walletIncomeDTO)).thenReturn(walletDTO);
        var responseEntity = this.walletController.depositOperations(walletIncomeDTO);

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(walletDTO,responseEntity.getBody());
    }
    @Test
    void WithdrawOperationsTest(){
        //given
        WalletIncomeDTO walletIncomeDTO = new WalletIncomeDTO(UUID.randomUUID(),WITHDRAW,new BigDecimal(1));
        WalletDTO walletDTO = new WalletDTO(UUID.randomUUID(),new BigDecimal(1));

        //when
        when(this.walletService.depositOperations(walletIncomeDTO)).thenReturn(walletDTO);
        var responseEntity = this.walletController.depositOperations(walletIncomeDTO);

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(walletDTO,responseEntity.getBody());
    }
    @Test
    void allWallets_ReturnsValidResponse(){
        //given
        WalletResponse walletResponse = new WalletResponse();

        var wallets = List.of(new WalletDTO(UUID.randomUUID(),new BigDecimal(1)),
                new WalletDTO(UUID.randomUUID(),new BigDecimal(2)));
        walletResponse.setContent(wallets);

        //when
        when(this.walletService.allWallets()).thenReturn(walletResponse);
        var responseEntity = this.walletController.allWallets();

        // then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(walletResponse,responseEntity.getBody());





    }
}