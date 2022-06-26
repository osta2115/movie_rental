package hibernate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class ClientBasicInfo {

    private Integer id;
    private String login;
    private String firstName;
    private String lastName;
}
