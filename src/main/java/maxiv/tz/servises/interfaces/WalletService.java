package maxiv.tz.servises.interfaces;

import maxiv.tz.DTO.WalletDTO;
import maxiv.tz.DTO.WalletIncomeDTO;
import maxiv.tz.DTO.WalletResponse;

import java.util.UUID;

public interface WalletService {

    WalletDTO findWalletById(UUID id);


    WalletDTO depositOperations(WalletIncomeDTO walletIncomeDTO);
    //WalletDTO createWallet(WalletDTO walletDTO);
    WalletResponse allWallets();

}
