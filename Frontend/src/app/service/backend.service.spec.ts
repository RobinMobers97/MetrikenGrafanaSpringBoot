import {TestBed} from '@angular/core/testing';

import {BackendService} from './backend.service';
import {HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';


describe('BackendService', () => {

  let httpMock: HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        HttpClientTestingModule
      ],
      declarations: [],
      providers: [
       BackendService
      ]
    });
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    const service: BackendService = TestBed.get(BackendService);
    expect(service).toBeTruthy();
  });
});
