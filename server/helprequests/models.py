from django.db import models
from django_extensions.db.models import TimeStampedModel

from patients.models import Patient
from skills.models import Skill


class HelpRequest(TimeStampedModel):
    patient = models.ForeignKey(Patient, models.CASCADE)
    title = models.CharField(max_length=100)
    text = models.TextField(blank=True)
    skill = models.ForeignKey(Skill, models.SET_NULL, blank=True, null=True)
    lat = models.DecimalField(max_digits=8, decimal_places=3, blank=True, null=True)
    lon = models.DecimalField(max_digits=8, decimal_places=3, blank=True, null=True)

    def __str__(self):
        return f'{self.patient} request: {self.title}'
