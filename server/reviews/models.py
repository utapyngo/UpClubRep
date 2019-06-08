from django.db import models
from django_extensions.db.models import TimeStampedModel

from patients.models import Patient
from volunteers.models import Volunteer


class Review(TimeStampedModel, models.Model):
    from_member = models.ForeignKey(Patient, models.CASCADE, 'reviews_given')
    to_member = models.ForeignKey(Volunteer, models.CASCADE, 'reviews_received')
    text = models.TextField()
    rating = models.IntegerField()

    def __str__(self):
        return (f'Review {self.id} from {self.from_member} to {self.to_member} '
                f'on {self.created.date().isoformat()}')
