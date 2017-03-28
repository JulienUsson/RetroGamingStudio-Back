package fr.isima.service;

import fr.isima.model.Console;
import fr.isima.repository.ConsoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class ConsoleService {
    @Autowired
    private ConsoleRepository consoleRepository;

    public Set<Console> findAll() {
        return consoleRepository.findAll();
    }

    public Console findById(Long id) {
        return consoleRepository.findById(id);
    }

    public Console save(Console console) {
        return consoleRepository.save(console);
    }

    public void deleteById(Long id) {
        consoleRepository.deleteById(id);
    }
}
