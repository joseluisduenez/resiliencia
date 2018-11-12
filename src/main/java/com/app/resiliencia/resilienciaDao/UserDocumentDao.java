package com.app.resiliencia.resilienciaDao;
import java.util.List;

import com.app.resiliencia.model.*;
public interface UserDocumentDao {

	public List<UserDocument> getUserDocs(Integer UserId);
	public UserDocument getDocById(Integer id);
	public void addDocument(UserDocument doc);
	public void updateDocument(UserDocument doc);
	public void deleteDoc(Integer id);
	public Integer getLastId();
	
}
