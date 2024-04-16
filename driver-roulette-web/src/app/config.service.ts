import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable()
export class ConfigService {
  private apiUrl = "http://localhost:8080/api/v1/driverroulette"

  constructor(private http: HttpClient) {
  }

  getNames() {
    return this.http.get<string[]>(this.apiUrl + "/names", {observe: 'body', responseType: 'json'});
  }
}
