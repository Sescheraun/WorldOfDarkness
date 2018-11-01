package sescheraun.worldoffuturedarkness.generator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * The type Role.
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Transient
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    private String roleName;

    private String userName;

    private Boolean isDeleted;

    /**
     * Gets isDeleted.
     *
     * @return the is deleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * Sets isDeleted.
     *
     * @param deleted the deleted
     */
    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    /**
     * Instantiates a new Role.
     */
    public Role() {
        this.isDeleted = false;
    }

    /**
     * Instantiates a new Role.
     *
     * @param user     the user
     * @param roleName the role name
     */
    public Role(User user, String roleName) {
        this();
        this.user = user;
        this.roleName = roleName;
        this.userName = user.getUserName();
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
        this.userName = user.getUserName();
    }

    /**
     * Gets role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets role name.
     *
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }


    /**
     * Over ridden .equals method
     * @param o the object that is being tested
     * @return the results of the test.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id
                && Objects.equals(user, role.user)
                && Objects.equals(roleName, role.roleName)
                && Objects.equals(userName, role.userName)
                ;
    }

    /**
     * Over ridden hash code method
     * @return the new hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, user, roleName, userName);
    }

    /**
     * Over ridden to string method for easier printing
     * @return the details for the class.
     */

    @Override
    public String toString() {
        return "Role{" +
                "user=" + user.getUserName() +
                ", roleName='" + roleName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
