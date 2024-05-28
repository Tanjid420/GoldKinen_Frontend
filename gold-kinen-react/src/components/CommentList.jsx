// import React from 'react';
import PropTypes from 'prop-types';
const CommentList = ({ comments }) => {
  return (
    <ul className="mt-4 pl-4 border-l border-gray-200">
      {comments.map(comment => (
        <li key={comment.id} className="mb-2">
          <p className="text-gray-800">{comment.body}</p>
          <p className="text-sm text-gray-500">- {comment.email}</p>
        </li>
      ))}
    </ul>
  );
};


CommentList.propTypes = {
  comments: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      body: PropTypes.string.isRequired,
      email: PropTypes.string.isRequired,
    })
  ).isRequired,
};

export default CommentList;
