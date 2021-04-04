package boaz.web.proto.boaz.local.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
public class Member  implements UserDetails {
    @Id
    private Long id;
    private String userId;
    private String password;

    private String roles = "ROLE_USER";

    @Builder
    public Member(Long id, String password, String userId) {
        this.id = id;
        this.password = password;
        this.userId = userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        if (this.roles.length() > 0) {
            for (String role :
                    this.roles.split(",")) {
                auth.add(new SimpleGrantedAuthority(role));
            }
            return auth;
        }
        else{
            return new ArrayList<>();
        }
    }

    @Override
    public String getUsername() {
        return this.userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

