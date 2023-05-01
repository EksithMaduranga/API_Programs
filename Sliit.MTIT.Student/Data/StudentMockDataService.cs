namespace Sliit.MTIT.Student.Data
{
    public static class StudentMockDataService
    {
        public static List<Models.Student> Students = new List<Models.Student>()
        {
            new Models.Student { Id = 1, Name = "Dinesh", Address = "Colombo", Age = 22 },
            new Models.Student { Id = 2, Name = "Kumar", Address = "Galle", Age = 21 },
            new Models.Student { Id = 3, Name = "Ravi", Address = "Jaffna", Age = 23 },
            new Models.Student { Id = 4, Name = "Kamal", Address = "Colombo", Age = 20 },
            new Models.Student { Id = 5, Name = "Pavi", Address = "Kandy", Age = 23 }
        };

    }
}
