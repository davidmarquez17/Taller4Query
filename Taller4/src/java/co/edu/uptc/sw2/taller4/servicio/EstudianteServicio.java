package co.edu.uptc.sw2.taller4.servicio;

import co.edu.uptc.sw2.taller4.dto.EstudianteDTO;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/Estudiante")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EstudianteServicio {

    /**
     * retorna una lista con los Estudiantes que se encuentran en la base de datos
     *
     * @retrun retorna una lista de EstudianteDTO
     * @generated
     */
    @GET
    public List<EstudianteDTO> obtenerTodosEstudiantes() {
        return ProveedorInformacion.instance().obtenerTodos(EstudianteDTO.class);
    }
    
    /**
     * @param id identificador del elemento Estudiante
     * @return Estudiante del id dado
     * @generated
     */
    @GET
    @Path("/{id}")
    public EstudianteDTO obtenerEstudiante(@PathParam("id") Long id) {
        return (EstudianteDTO) ProveedorInformacion.instance().obtener(EstudianteDTO.class, id);
    }

    /**
     * almacena la informacion de Estudiante
     *
     * @param dto Estudiante a guardar
     * @return Estudiante con los cambios realizados por el proceso de guardar
     * @generated
     */
    @POST
    public EstudianteDTO guardarEstudiante(EstudianteDTO dto) {
        return (EstudianteDTO) ProveedorInformacion.instance().guardar(dto);
    }

    /**
     * elimina el registro Estudiante con el identificador dado
     *
     * @param id identificador del Estudiante
     * @generated
     */
    @DELETE
    @Path("/{id}")
    public void borrarEstudiante(@PathParam("id") Long id) {
        ProveedorInformacion.instance().eliminar(EstudianteDTO.class, id);
    }
    @GET
    @Path("/consulta")
    public List<EstudianteDTO> consultarEstudiantes(@QueryParam("nombre") String nombre){
        List<EstudianteDTO> lista=obtenerTodosEstudiantes();
        List<EstudianteDTO> respuesta=new ArrayList<>();
        for(EstudianteDTO E:lista){
            if(E.getNombres().toUpperCase().contains(nombre.toUpperCase())){
                respuesta.add(E);
            }
        }
        return respuesta;
    }
}