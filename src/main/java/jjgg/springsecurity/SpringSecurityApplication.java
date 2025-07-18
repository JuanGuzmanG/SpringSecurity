package jjgg.springsecurity;

import jjgg.springsecurity.persistence.entities.PermissionEntity;
import jjgg.springsecurity.persistence.entities.RoleEntity;
import jjgg.springsecurity.persistence.entities.RoleEnum;
import jjgg.springsecurity.persistence.entities.UserEntity;
import jjgg.springsecurity.persistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository) {
         return args -> {
             PermissionEntity createPermission = PermissionEntity.builder()
                     .name("CREATE")
                     .build();
             PermissionEntity readPermission = PermissionEntity.builder()
                     .name("READ")
                     .build();
             PermissionEntity updatePermission = PermissionEntity.builder()
                     .name("UPDATE")
                     .build();
             PermissionEntity deletePermission = PermissionEntity.builder()
                     .name("DELETE")
                     .build();
             PermissionEntity TestPermission = PermissionEntity.builder()
                     .name("TEST")
                     .build();

             RoleEntity roleAdmin = RoleEntity.builder()
                     .roleEnum(RoleEnum.ADMIN)
                     .permissionList(Set.of(createPermission, readPermission,
                             updatePermission, deletePermission))
                     .build();
             RoleEntity roleUser = RoleEntity.builder()
                     .roleEnum(RoleEnum.USER)
                     .permissionList(Set.of(createPermission, readPermission))
                     .build();
             RoleEntity roleInvited = RoleEntity.builder()
                     .roleEnum(RoleEnum.INVITED)
                     .permissionList(Set.of(readPermission))
                     .build();
             RoleEntity roleDeveloper = RoleEntity.builder()
                        .roleEnum(RoleEnum.DEVELOPER)
                        .permissionList(Set.of(createPermission, readPermission,
                                updatePermission, deletePermission, TestPermission))
                        .build();

             UserEntity userSan = UserEntity.builder()
                     .username("san")
                     .password("$2a$12$IWZ82YsdPqfsZz6kCWtreORw94iLPdiwZ45L1QBdvpqspAE/A8176")
                     .isEnabled(true)
                     .accountNoExpired(true)
                     .accountNoLocked(true)
                     .credentialNoExpired(true)
                     .roles(Set.of(roleAdmin))
                     .build();
             UserEntity userBen = UserEntity.builder()
                     .username("Ben")
                     .password("$2a$12$IWZ82YsdPqfsZz6kCWtreORw94iLPdiwZ45L1QBdvpqspAE/A8176")
                     .isEnabled(true)
                     .accountNoExpired(true)
                     .accountNoLocked(true)
                     .credentialNoExpired(true)
                     .roles(Set.of(roleUser))
                     .build();
             UserEntity userDan = UserEntity.builder()
                     .username("Dan")
                     .password("$2a$12$IWZ82YsdPqfsZz6kCWtreORw94iLPdiwZ45L1QBdvpqspAE/A8176")
                     .isEnabled(true)
                     .accountNoExpired(true)
                     .accountNoLocked(true)
                     .credentialNoExpired(true)
                     .roles(Set.of(roleInvited))
                     .build();
             UserEntity userLau = UserEntity.builder()
                     .username("Lau")
                     .password("$2a$12$IWZ82YsdPqfsZz6kCWtreORw94iLPdiwZ45L1QBdvpqspAE/A8176")
                     .isEnabled(true)
                     .accountNoExpired(true)
                     .accountNoLocked(true)
                     .credentialNoExpired(true)
                     .roles(Set.of(roleDeveloper))
                     .build();
             UserEntity userFred = UserEntity.builder()
                     .username("Fred")
                     .password("$2a$12$IWZ82YsdPqfsZz6kCWtreORw94iLPdiwZ45L1QBdvpqspAE/A8176")
                     .isEnabled(true)
                     .accountNoExpired(true)
                     .accountNoLocked(true)
                     .credentialNoExpired(true)
                     .roles(Set.of(roleInvited, roleAdmin))
                     .build();

             userRepository.saveAll(List.of(userSan, userBen, userDan, userLau, userFred));
         };
    }
}
