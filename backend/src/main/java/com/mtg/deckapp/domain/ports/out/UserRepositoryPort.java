package com.mtg.deckapp.domain.ports.out;

import com.mtg.deckapp.domain.model.user.User;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    void deleteById(Long id);
}
