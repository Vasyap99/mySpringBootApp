package kko.proj1.prog.repo;

import kko.proj1.prog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post,Long> {
}
