package ru.zolotarev.portfolio.repository.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "files", schema = "public", catalog = "portfolio")
public class FileEntity {

	private int id;
	private String name;
	private String path;
	private FileType type;
	private Integer groupId;
	private int index;

	@Id
	@Column(name = "id", nullable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "path", nullable = false, unique = true, length = 50)
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Basic
	@Column(name = "type", nullable = false)
	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	@Basic
	@Column(name = "group_id", unique = true)
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Basic
	@Column(name = "index", nullable = false)
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		FileEntity that = (FileEntity) o;
		return id == that.id &&
				index == that.index &&
				Objects.equals(name, that.name) &&
				Objects.equals(path, that.path) &&
				type == that.type &&
				Objects.equals(groupId, that.groupId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, path, type, groupId, index);
	}
}
