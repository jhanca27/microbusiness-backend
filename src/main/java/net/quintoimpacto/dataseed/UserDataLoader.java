// package net.quintoimpacto.dataseed;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import net.quintoimpacto.ubuntuapi.entity.UserAdm;
// import net.quintoimpacto.ubuntuapi.repository.UserAdRepository;


// @Component
// public class UserDataLoader implements CommandLineRunner {

//     @Autowired
//     UserAdRepository userAdRepository;

//     @Override 
//     public void run(String... args) throws Exception {
//         loadUserData();
//     }

//     private void loadUserData() {
//         if (userAdRepository.count() == 0) {
//             userAdRepository.save(new UserAdm("admin@example.com"));
//         }
//         System.out.println(userAdRepository.count() + " admin users loaded");
//     }
    
// }
