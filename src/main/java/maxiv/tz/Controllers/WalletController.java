package maxiv.tz.Controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maxiv.tz.DTO.WalletDTO;
import maxiv.tz.DTO.WalletIncomeDTO;
import maxiv.tz.DTO.WalletResponse;
import maxiv.tz.servises.WalletServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class WalletController {

    private final WalletServiceImpl walletService;



    @GetMapping("/wallets/{WALLET_UUID}")
    public ResponseEntity<WalletDTO> walletBalance(@PathVariable UUID WALLET_UUID) {
        log.info("balance request");
        return new ResponseEntity<>(walletService.findWalletById(WALLET_UUID), HttpStatus.OK);
    }
    @PostMapping("/wallet")
    public ResponseEntity<WalletDTO> depositOperations(@Valid @RequestBody WalletIncomeDTO walletIncomeDTO) {
        log.info("Data received {}",walletIncomeDTO);
        return new ResponseEntity<>(walletService.depositOperations(walletIncomeDTO),HttpStatus.OK);
    }
    @GetMapping("/wallets")
    public ResponseEntity<WalletResponse> allWallets(){
        return new ResponseEntity<>(walletService.allWallets(),HttpStatus.OK);

    }
   // @PostMapping("/new/wallet")
   // public ResponseEntity <WalletDTO> createWallet( @RequestBody WalletDTO walletDTO){
   //     return new ResponseEntity<>(walletService.createWallet(walletDTO),HttpStatus.CREATED);
//
//
   // }



}
