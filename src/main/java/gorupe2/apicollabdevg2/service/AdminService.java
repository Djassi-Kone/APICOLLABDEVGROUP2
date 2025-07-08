package gorupe2.apicollabdevg2.service;

import gorupe2.apicollabdevg2.entity.Admin;
import gorupe2.apicollabdevg2.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;


    public Admin AjouterAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> ListerAdmin() {
        return adminRepository.findAll();
    }

    public Optional<Admin> AfficherAdminParId(int id) {
        return adminRepository.findById(id);
    }

    public Admin ModifierAdmin(int id, Admin admin) {
        admin.setId(id);
        return adminRepository.save(admin);
    }

    public void SupprimerAdmin(int id) {
        adminRepository.deleteById(id);
    }
}
