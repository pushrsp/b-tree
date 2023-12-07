package me.project;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryDbTest {
    @Test
    public void can_add_data_to_db() throws Exception {
        //given
        MemoryDb memoryDb = new MemoryDb();

        Member m1 = new Member("t1", "t1", 10);
        Member m2 = new Member("t2", "t2", 10);

        //when
        memoryDb.add(m1);
        memoryDb.add(m2);

        //then
        assertThat(memoryDb.getByUsername(m1.getUsername())).isNotEmpty();
        assertThat(memoryDb.getByUsername(m2.getUsername())).isNotEmpty();
        assertThat(memoryDb.getSize()).isEqualTo(2);
    }

    @Test
    public void can_ignore_duplicated_username() throws Exception {
        //given
        MemoryDb memoryDb = new MemoryDb();

        Member m1 = new Member("t1", "t1", 10);
        Member m2 = new Member("t1", "t2", 10);

        //when
        memoryDb.add(m1);
        memoryDb.add(m2);

        //then
        assertThat(memoryDb.getSize()).isEqualTo(1);
    }
}
