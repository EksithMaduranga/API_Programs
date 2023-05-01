using System.Reflection.Metadata.Ecma335;
using Microsoft.AspNetCore.Mvc;
using Sliit.MTIT.Student.Data;
using Sliit.MTIT.Student.Services;

// For more information on enabling Web API for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace Sliit.MTIT.Student.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class StudentController : ControllerBase
    {
        private readonly IStudentService _studentService;

        public StudentController(IStudentService studentService)
        {
            _studentService = studentService ?? throw new ArgumentNullException(nameof(studentService));    
        }

        // GET: api/<StudentController>
        [HttpGet]
        public IActionResult Get()
        {
            return Ok(_studentService.GetStudents());
        }

        // GET api/<StudentController>/5
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            return _studentService.GetStudent(id) != null ? Ok(_studentService.GetStudent(id)) : NoContent();
        }

        // POST api/<StudentController>
        [HttpPost]
        public IActionResult Post([FromBody] Models.Student student)
        {
            return Ok(_studentService.AddStudent(student));
        }

        // PUT api/<StudentController>/5
        [HttpPut]
        public IActionResult Put([FromBody] Models.Student student)
        {
            return Ok(_studentService.UpdateStudent(student));
        }

        // DELETE api/<StudentController>/5
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            var result = _studentService.DeleteStudent(id);

            return result.HasValue & result == true ? Ok($"student with ID:{id} got deleted successfully.")
                : BadRequest($"Unable to delete the studend with ID:{id}.");
        }
    }
}
