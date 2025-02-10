package maxiv.tz.DTO;

import lombok.Data;

import java.util.List;

@Data
public class WalletResponse {
    private List<WalletDTO> content;
}
