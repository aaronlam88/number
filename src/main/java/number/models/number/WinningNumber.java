package number.models.number;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class WinningNumber implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("Number")
    private Integer number;

    @SerializedName("IsSpecial")
    private Boolean isSpecial;

    @SerializedName("Name")
    private String name;
}
