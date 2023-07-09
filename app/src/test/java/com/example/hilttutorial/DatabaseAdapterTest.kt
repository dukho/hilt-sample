package com.example.hilttutorial

import android.content.Context
import com.example.hilttutorial.database.DatabaseAdapter
import com.example.hilttutorial.database.DatabaseService
import io.mockk.every
import io.mockk.mockk
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

//@RunWith(MockitoJUnitRunner::class)
class DatabaseAdapterTest {
//    @Mock
//    lateinit var mockContext: Context
//
//    @Mock
//    lateinit var mockService: DatabaseService
//
//    @Before
//    fun setup() {
//        MockitoAnnotations.initMocks(this)
//    }

    @Test
    fun testDatabaseAdapter() {
        val mockContext = mockk<Context>()
        val mockService = mockk<DatabaseService>()
        every {
            mockService.log(any())
        } returns Unit
        val adapter = DatabaseAdapter(mockContext, mockService)
        val bo = ByteArrayOutputStream()
        System.setOut(PrintStream(bo))
        adapter.log("unit testing")
        bo.flush()
        val lines = String(bo.toByteArray())
        assert(lines.contains("context available"))
        assert(lines.contains("unit testing"))
    }
}