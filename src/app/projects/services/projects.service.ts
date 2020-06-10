import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { UrlService } from '../../shared/url.service';
import { Observable } from 'rxjs';
import { Project } from '../beans/project';
import { map } from 'rxjs/operators';

@Injectable()
export class ProjectsService {
  private appUrl = this.urlService.getUrl() + "projects";
  private headers = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(
    private http: HttpClient,
    private urlService: UrlService
  ) { }

  createProject(project : Project) : Observable<Project> {
    return this.http.post(this.appUrl, project, { withCredentials: true})
     .pipe(map(resp => resp as Project));
  }

  getProjects() : Observable<Project[]>{
    return this.http.get(this.appUrl, { withCredentials: true})
     .pipe(map(resp => resp as Project[]));
  }

  getProject(projectID : Number): Observable<Project>{
    return this.http.get(this.appUrl + '/' + projectID,  { withCredentials: true})
     .pipe(map(resp => resp as Project));
  }

  updateProject(project : Project) {
    return this.http.put(this.appUrl, project, { withCredentials: true});
  }
  
  /*
   * I'm not sure how to submit a delete request with an object that's supposed to be deleted.
   * Until that's figured out, this will remain commented out.
   * 
  deleteProject(project : Project) {
    return this.http.delete(this.appUrl, { withCredentials: true});
  }
   */
}
