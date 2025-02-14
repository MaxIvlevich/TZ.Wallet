package maxiv.tz.servises;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import maxiv.tz.DTO.WalletDTO;
import maxiv.tz.DTO.WalletIncomeDTO;
import maxiv.tz.DTO.WalletResponse;
import maxiv.tz.exceptionHandler.IncorrectDataException;
import maxiv.tz.mapper.WalletMapper;
import maxiv.tz.models.Wallet;
import maxiv.tz.repository.WalletRepository;
import maxiv.tz.servises.interfaces.WalletService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static maxiv.tz.models.enums.OperationType.DEPOSIT;
import static maxiv.tz.models.enums.OperationType.WITHDRAW;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {
    private final WalletRepository walletRepository;

    @Override
    @Transactional
    public WalletDTO findWalletById(UUID id) {
        Wallet wallet = findWallet(id);
        return WalletMapper.walletToDTO(wallet);
    }

    @Override
    @Transactional
    public WalletDTO depositOperations(WalletIncomeDTO walletIncomeDTO) {
        Wallet wallet = findWallet(walletIncomeDTO.getWalletId());

        if (walletIncomeDTO.getOperationType().equals(DEPOSIT)){
            wallet.setAmount(new BigDecimal(String.valueOf(wallet.getAmount().add(walletIncomeDTO.getAmount()))));
            log.info("A deposit has been made: {}", walletIncomeDTO.getAmount());
        }
        if (walletIncomeDTO.getOperationType().equals(WITHDRAW)){
            if (wallet.getAmount().compareTo(walletIncomeDTO.getAmount())>=0){

                BigDecimal res  = new BigDecimal(String.valueOf(wallet.getAmount().subtract(walletIncomeDTO.getAmount())));
                wallet.setAmount(res);

            }else throw new IncorrectDataException("Not enough funds");
        }


        return WalletMapper.walletToDTO(wallet);

    }

    //@Override
    //public WalletDTO createWallet(WalletDTO walletDTO) {
//
    //    if(!walletRepository.existsById(walletDTO.getWalletId())){
    //        Wallet wallet = WalletMapper.toEntity(walletDTO);
    //        Wallet saveWallet = walletRepository.save(wallet);
    //        log.info("Создан Новый кошелек{} ",wallet);
//
    //        return  WalletMapper.walletToDTO(saveWallet);
    //    }
    //    return null;
    //}

    @Override
    public WalletResponse allWallets() {
        log.info("Calling all wallets");
        List<Wallet> wallets = (List<Wallet>) walletRepository.findAll();
        List<WalletDTO> walletDTO = wallets.stream()
                .map(WalletMapper::walletToDTO)
                .collect(Collectors.toList());
        WalletResponse walletResponse = new WalletResponse();
        walletResponse.setContent(walletDTO);

        return walletResponse;
    }


    public Wallet findWallet(UUID uuid){
        return walletRepository.findById(uuid)
                .orElseThrow(()-> new IllegalArgumentException("Wallet not found"));

    }



}
