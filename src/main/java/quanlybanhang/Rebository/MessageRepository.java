package quanlybanhang.Rebository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import quanlybanhang.Entity.MessageEntity;

@Repository
public interface MessageRepository  extends JpaRepository<MessageEntity, Integer>{

	
	@Query(value="select m.* from message m " + 
			"where m.notifi_id =:notifiId",nativeQuery = true)
	public MessageEntity findByIdNotiFiId (@Param("notifiId") int notifiId);
}
