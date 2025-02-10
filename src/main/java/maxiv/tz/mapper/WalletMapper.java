package maxiv.tz.mapper;

import maxiv.tz.DTO.WalletDTO;
import maxiv.tz.DTO.WalletIncomeDTO;
import maxiv.tz.models.Wallet;
import org.springframework.stereotype.Component;

@Component
public class WalletMapper {

    public static WalletDTO walletToDTO(Wallet wallet){
        WalletDTO walletDTO = new WalletDTO();
        walletDTO.setWalletId(wallet.getWalletId());
        walletDTO.setAmount(wallet.getAmount());
        return walletDTO;

    }


   // public static Wallet toEntity(WalletIncomeDTO walletIncomeDTO) {
   //     Wallet wallet = new Wallet();
   //     wallet.setAmount(walletIncomeDTO.getAmount());
   //     wallet.setWalletId(walletIncomeDTO.getWalletId());
   //     return wallet;
//
   // }
}
