package dev.ledesma.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No Meeting Found")
public class MeetingNotFoundException extends RuntimeException {


}
