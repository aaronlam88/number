package number.models.number;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Prize implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("PrizeTypeDescription")
    private String prizeTypeDescription;

    @SerializedName("Count")
    private Integer count;

    @SerializedName("Amount")
    private Integer amount;
}
