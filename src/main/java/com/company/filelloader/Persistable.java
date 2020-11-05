package com.company.filelloader;

import java.nio.ByteBuffer;

interface Persistable {

	public void persist(ByteBuffer buffer);

	public void recover(ByteBuffer buffer);
}
