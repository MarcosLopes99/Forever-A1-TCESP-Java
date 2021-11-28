package br.com.fiap.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.fiap.model.MunicipioModel;

@Repository
public interface MunicipioRepository extends JpaRepository<MunicipioModel, Long>{
	
	@Query("SELECT m from MunicipioModel m WHERE m.statusChecagemMunicipio = ?1")
	List<MunicipioModel> findMunicipiosByStatusChecagem(String statusChecagemMunicipio);
	
	@Query("SELECT m from MunicipioModel m WHERE m.nomeMunicipio = ?1")
	MunicipioModel findMunicipioByNome(String nomeMunicipio);
	
	@Query("SELECT m from MunicipioModel m WHERE m.userResponsavel.idUser = ?1")
	List<MunicipioModel> findMunicipiosChecadosPeloUser(long idUser);
	
	@Query("SELECT m from MunicipioModel m WHERE m.ultimaChecagemMunicipio > ?1 AND m.statusChecagemMunicipio = 'CHECADO'")
	List<MunicipioModel> findMunicipiosChecadosAPartirDeUmaData(Date ultimaChecagemMunicipio);

}
