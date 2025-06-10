@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class TaskControllerTest
{
    @Autowired
    TaskController taskController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp()
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(taskController).build();
    }

    @Test
    @Transactional
    public void testEmptyTaskListViaREST()
    {
        try
        {
            mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
                .andExpect(MockMvcRequestBuilders.content().string(Matchers.containsString("[]")));
        } catch(Exception e)
        {
          fail("test failed: " + e.getMessage());
          e.printStackTrace();
        }
    }
}
