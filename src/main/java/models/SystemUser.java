package models;

import Constant.RoleTypeEnum;
import Constant.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class SystemUser {
    private String employeeName;
    private String username;
    private RoleTypeEnum role;
    private StatusEnum status;
    private String password;

    public void setEmployeeName(String employeeName) {
        this.employeeName= employeeName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRole(RoleTypeEnum role) {
        this.role = role;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getUsername() {
        return username;
    }

    public RoleTypeEnum getRole() {
        return role;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }
}
