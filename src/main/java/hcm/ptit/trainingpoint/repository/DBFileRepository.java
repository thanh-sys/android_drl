package hcm.ptit.trainingpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcm.ptit.trainingpoint.enitty.DBFile;

public interface DBFileRepository extends JpaRepository<DBFile, String> {
}
