import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class SlotmachineService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/rest/slotmachine');
  }

  get(id: string) {
    return this.http.get('//localhost:8080/rest/slotmachine/'+id);
  }

  getBySlotroomId(slotroomId: string): Observable<any> {
    return this.http.get('//localhost:8080/rest/slotmachine?slotroomId='+slotroomId);
  }

  create(slotmachine: any): Observable<any> {
    return this.http.post('//localhost:8080/rest/slotmachine', slotmachine);
  }

  update(slotmachine: any): Observable<any> {
    return this.http.put('//localhost:8080/rest/slotmachine', slotmachine);
  }

  delete(id: string) {
    return this.http.delete('//localhost:8080/rest/slotmachine/'+id);
  }
}
