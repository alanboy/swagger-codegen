/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.25-SNAPSHOT).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import java.util.Map;
import io.swagger.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Validated
public interface StoreApi {

    Logger log = LoggerFactory.getLogger(StoreApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "Delete purchase order by ID", description = "For valid response try integer IDs with positive integer value.\\ \\ Negative or non-integer values will generate API errors", tags={ "store" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "404", description = "Order not found") })
    @RequestMapping(value = "/store/order/{orderId}",
        method = RequestMethod.DELETE)
    default ResponseEntity<Void> deleteOrder(@Min(1L)@Parameter(in = ParameterIn.PATH, description = "ID of the order that needs to be deleted", required=true, schema=@Schema(allowableValues={  }, minimum="1"
)) @PathVariable("orderId") Long orderId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Returns pet inventories by status", description = "Returns a map of status codes to quantities", security = {
        @SecurityRequirement(name = "api_key")    }, tags={ "store" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(array = @ArraySchema(schema = @Schema(implementation = Map.class)))) })
    @RequestMapping(value = "/store/inventory",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Map<String, Integer>> getInventory() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"key\" : 0\n}", Map.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Find purchase order by ID", description = "For valid response try integer IDs with value >= 1 and <= 10.\\ \\ Other values will generated exceptions", tags={ "store" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Order.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        
        @ApiResponse(responseCode = "404", description = "Order not found") })
    @RequestMapping(value = "/store/order/{orderId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Order> getOrderById(@Min(1L) @Max(10L) @Parameter(in = ParameterIn.PATH, description = "ID of pet that needs to be fetched", required=true, schema=@Schema(allowableValues={  }, minimum="1", maximum="10"
)) @PathVariable("orderId") Long orderId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"petId\" : 6,\n  \"quantity\" : 1,\n  \"id\" : 0,\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : false,\n  \"status\" : \"placed\"\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "Place an order for a pet", description = "", tags={ "store" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(implementation = Order.class))),
        
        @ApiResponse(responseCode = "400", description = "Invalid Order") })
    @RequestMapping(value = "/store/order",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    default ResponseEntity<Order> placeOrder(@Parameter(in = ParameterIn.DEFAULT, description = "order placed for purchasing the pet", required=true, schema=@Schema()) @Valid @RequestBody Order body) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\n  \"petId\" : 6,\n  \"quantity\" : 1,\n  \"id\" : 0,\n  \"shipDate\" : \"2000-01-23T04:56:07.000+00:00\",\n  \"complete\" : false,\n  \"status\" : \"placed\"\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default StoreApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

