package maxiv.tz.Controllers;



import maxiv.tz.DTO.WalletDTO;
import maxiv.tz.repository.WalletRepository;
import maxiv.tz.servises.WalletServiceImpl;
import maxiv.tz.servises.interfaces.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc(printOnlyOnFailure = false)
public class WalletControllerTestIT {


    @Autowired
    MockMvc mockMvc;
    @Autowired
    WalletRepository walletRepository;

    WalletServiceImpl walletService;


    void getAllWalletsTest() throws Exception{

        var requestBuilder = MockMvcRequestBuilders.get("/api/v1/wallets");

       WalletDTO walletDTO = new WalletDTO(UUID.randomUUID(),new BigDecimal(1));

        this.mockMvc.perform(requestBuilder)
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON),
                        content().json("""



                                     """)
                        );


    }




}
