package ua.romankh3.movie.tracking.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.romankh3.movie.tracking.db.model.UserModel;
import ua.romankh3.movie.tracking.db.model.User_x_ActorModel;
import ua.romankh3.movie.tracking.db.model.User_x_ActorPK;

import java.util.List;

public interface User_x_ActorModelRepository extends JpaRepository<User_x_ActorModel, User_x_ActorPK> {

    User_x_ActorModel save(final User_x_ActorModel user_x_actorModel);

    List<User_x_ActorModel> findByUserModel(final UserModel userModel);

    List<User_x_ActorModel> findAll();
}
