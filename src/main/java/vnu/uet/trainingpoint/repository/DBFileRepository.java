package vnu.uet.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vnu.uet.trainingpoint.enitty.DBFile;

public interface DBFileRepository extends JpaRepository<DBFile, String> {
}
