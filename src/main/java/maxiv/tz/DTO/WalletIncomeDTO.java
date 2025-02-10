package maxiv.tz.DTO;

import jakarta.validation.constraints.Positive;
import lombok.*;
import maxiv.tz.models.enums.OperationType;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletIncomeDTO {
    @NotNull
    UUID walletId;
    @NotNull
    private OperationType operationType;

    @Positive
    BigDecimal amount;




}


